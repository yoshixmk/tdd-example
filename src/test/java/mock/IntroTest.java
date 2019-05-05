package mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IntroTest {

	@Mock
	private LinkedList<String> mockedList;
	@Mock
	private LinkedList<String> mockedList2;
	@Mock
	private LinkedList<String> mockedList3;

	@Test
	void 初めのテスト() {
		mockedList.add("one");
		mockedList.clear();

		verify(mockedList).add("one");
		verify(mockedList).clear();

		// これ以上呼び出しが存在しないこと
		verifyNoMoreInteractions(mockedList);
	}

	@Test
	void スタブを順番に実行するテスト() {
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());

		assertEquals("first", mockedList.get(0));
		assertThrows(RuntimeException.class, () -> mockedList.get(1));
		assertNull(mockedList.get(999));

		// 順序指定
		InOrder inOrder = inOrder(mockedList);
		inOrder.verify(mockedList).get(0);
		inOrder.verify(mockedList).get(1);
		inOrder.verify(mockedList).get(999);

		verifyNoMoreInteractions(mockedList);
	}

	@Test
	void 引数マッチャーのテスト() {
		when(mockedList.get(anyInt())).thenReturn("element");

		mockedList.get(999);

		verify(mockedList).get(anyInt());
	}

	@Test
	void 呼び出し回数のテスト() {
		mockedList.add("once");
		mockedList.add("twice");
		mockedList.add("twice");
		mockedList.add("atLeastOnce");

		verify(mockedList, times(1)).add("once");
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, never()).add("never happened");

		verify(mockedList, atLeastOnce()).add("atLeastOnce");
		// other expression, atLeast(2), atMost(5)
	}

	@Test
	void 例外をモックするテスト() {
		doThrow(new RuntimeException()).when(mockedList).clear();
		assertThrows(RuntimeException.class, () -> mockedList.clear());
	}

	@Test
	void 影響を与えないテスト() {
		mockedList.add("one");
		// mockedList.add("two");

		verify(mockedList).add("one");
		verify(mockedList, never()).add("two");

		// 他のmockへは影響がないこと
		verifyZeroInteractions(mockedList2, mockedList3);
		// mockへの変更が他にはないこと
		verifyNoMoreInteractions(mockedList);
	}
	
	@Test
	void 呼び出しが同じで返り値が異なるケース() {
		when(mockedList.get(0))
		   .thenReturn("one", "two");
		assertEquals("one", mockedList.get(0));
		assertEquals("two", mockedList.get(0));
	}
}
