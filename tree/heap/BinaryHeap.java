package tree.heap;
  
import java.util.ArrayList;
import java.util.Collections;
  
  class BinaryHeap {
      
      ArrayList<Integer> heap;
      
      BinaryHeap () {
          heap = new ArrayList<Integer>();
      }
  
      /*
       * Continues to bubble values up the tree until we
       * find a node that is greater than it
       */
      public void bubbleUp (int index) {
          if (index == 0) {return;}
  
          int parent = getParent(index);
  
          if (heap.get(parent) < heap.get(index)) {
              Integer temp = heap.get(index);
              heap.set(index, heap.get(parent));
              heap.set(parent, temp);
              bubbleUp(parent);
          }
  
      }
      
      public void insert (Integer toInsert) {
          heap.add(toInsert);
          bubbleUp(heap.size() - 1);
      }
  
      // Traversal helpers
      public int getParent (int index) {
          return (index - 1) / 2;
      }
      
      public int getChild (int index, char child) {
          int result = (index * 2) + 1;
          if (child == 'R') {
              result++;
          }
          return result;
      }
      
      public void print () {
          for (int i = 0; i < heap.size(); i++) {
              System.out.println(heap.get(i));
          }
      }
      
      public ArrayList<Integer> getSortedElements () {
          if(heap == null || heap.size()==1){
              return heap;
          }
          
          BinaryHeap sortedHeapHelper = new BinaryHeap();
          sortedHeapHelper.heap = heap;
          BinaryHeap sortedHeap = new BinaryHeap();
          int count = heap.size();
          while(count >= 1){
              Collections.swap(sortedHeapHelper.heap, 0, count-1);
              sortedHeap.heap.add(sortedHeapHelper.heap.get(count-1));
              sortedHeapHelper.heap.remove(sortedHeapHelper.heap.get(count-1));
              for(int i=1; i<count-1; i++){
                  sortedHeapHelper.bubbleUp(i);
              }
              count--;
          }
          return sortedHeap.heap;
      }      
}