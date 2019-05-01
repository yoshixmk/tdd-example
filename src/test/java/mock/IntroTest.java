package mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

@SuppressWarnings({ "rawtypes", "unchecked" })
class IntroTest {

	@Test
	void 初めのテスト() {
		List mockedList = mock(List.class);

		mockedList.add("one");
		mockedList.clear();

		verify(mockedList).add("one");
		verify(mockedList).clear();

		// これ以上呼び出しが存在しないこと
		verifyNoMoreInteractions(mockedList);
	}

	@Test
	void スタブを順番に実行するテスト() {
		LinkedList mockedList = mock(LinkedList.class);

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
		LinkedList<String> mockedList = mock(LinkedList.class);
		when(mockedList.get(anyInt())).thenReturn("element");

		mockedList.get(999);

		verify(mockedList).get(anyInt());
	}
}
