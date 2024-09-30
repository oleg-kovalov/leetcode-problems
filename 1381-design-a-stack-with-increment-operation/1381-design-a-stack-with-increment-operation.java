    class CustomStack {

        int[] array;
        int pointer;
        
        public CustomStack(int maxSize) {
            array = new int[maxSize];
            Arrays.fill(array, -1);
            pointer = -1;
        }

        public void push(int x) {
            if (pointer == array.length-1) return;
            
            pointer++;
            array[pointer] = x;
        }

        public int pop() {
            if (pointer == -1) return -1;
            pointer--;
            return array[pointer+1];
        }

        public void increment(int k, int val) {
            if (pointer == -1) return;
            
            for (int i=0; i <= Math.min(pointer, k-1); i++)
            {
                array[i] += val;
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */