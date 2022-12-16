import java.util.Arrays;
public class MinHeap
//02185076092 Kasım Yaşar        
{
	private final int[] Heap;
	private int index;
	private final int size;

	public MinHeap(int size) {
		this.size = size;
		this.index = 0;
		Heap = new int[size];
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int solCocuk(int i) {
		return (i * 2) + 1;
	}

	private int sagCocuk(int i) {
		return (i * 2) + 2;
	}

	private boolean isLeaf(int i) {
		return sagCocuk(i) >= size || solCocuk(i) >= size;
	}

	public void insert(int element) {
		if (index >= size) {
			return;
		}
		Heap[index] = element;
		int current = index;

		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		index++;
	}

	// yığından minimum öğeyi kaldırır ve döndürür
	public int remove() {
     // min yığın olduğu için kök = minimum
		int popped = Heap[0];
		Heap[0] = Heap[--index];
		minHeapify(0);
		return popped;
	}

	// düğümü i'de yığmak
	private void minHeapify(int i) {
	// Düğüm yaprak olmayan bir düğümse ve alt öğelerinden herhangi biri daha küçükse
		if (!isLeaf(i)) {
			if (Heap[i] > Heap[solCocuk(i)] ||
                  Heap[i] > Heap[sagCocuk(i)]) {
				if (Heap[solCocuk(i)] < Heap[sagCocuk(i)]) {
					swap(i, solCocuk(i));
					minHeapify(solCocuk(i));
				} else {
					swap(i, sagCocuk(i));
					minHeapify(sagCocuk(i));
				}
			}
		}
	}

	// minHeapify'ı kullanarak min yığınını oluşturur
	public void minHeap() {
		for (int i = (index - 1 / 2); i >= 1; i--) {
			minHeapify(i);
		}
	}

     // Yığın içeriğini yazdırma işlevi
	public void printHeap() {
		for (int i = 0; i < (index / 2); i++) {
			System.out.print("ebeveyn : " + Heap[i]);
			if (solCocuk(i) < index)
				System.out.print(" Sol : " + Heap[solCocuk(i)]);
			if (sagCocuk(i) < index)
				System.out.print(" Sag :" + Heap[sagCocuk(i)]);
			System.out.println();
		}
	}
	// yığının iki düğümünü değiştirir
	private void swap(int x, int y) {
		int tmp;
		tmp = Heap[x];
		Heap[x] = Heap[y];
		Heap[y] = tmp;
	}
	public static void main(String[] arg)
      {
	    MinHeap minHeap = new MinHeap(7);
	    minHeap.insert(3);
	    minHeap.insert(13);
	    minHeap.insert(7);
          minHeap.insert(16);
	    minHeap.insert(21);
	    minHeap.insert(12);
	    minHeap.insert(9);
	    minHeap.minHeap();

	   System.out.println("Minumum yigin : " + Arrays.toString(minHeap.Heap));
	   minHeap.printHeap();
	   System.out.println("\nMinumum deger : " + minHeap.remove());
	   System.out.println("\nMinumum deger:"+ Arrays.toString(minHeap.Heap));
	   minHeap.printHeap();
	}
}
