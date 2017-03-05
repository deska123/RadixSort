import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
 *  author  : Dennis Pratama Kamah (1306464562) | DAA - C
 *  version : 05.29.2015
*/
public class AmortizedQueueRadixSort 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Masukkan banyaknya data : ");
        int banyak = Integer.parseInt(buff.readLine());
        ArrayList<String> arr = new ArrayList<>();
        System.out.println("Masukkan data yang belum terurut sebanyak " + banyak + " angka, akhiri dengan <enter> :");
        for(int i = 0; i < banyak; i++) {
            arr.add(buff.readLine());
        }
        int kar = arr.get(0).length();
        ArrayList <ArrayList<String>> temp = new ArrayList<>();
        int acc = 0;
        for(int j = kar - 1; j >= 0; j--) {
            if(j == kar - 1) {
                temp.add(radixSort(arr, j));
            } else {
		temp.add(radixSort(temp.get(acc - 1), j));
            }
            acc++;
        }
        System.out.println(temp.size());
        System.out.println("Data setelah terurut :");
        for(int k = 0; k < temp.get(temp.size() - 1).size(); k++) {
            System.out.println(temp.get(temp.size() - 1).get(k));
        }
    }
    
    public static ArrayList<String> radixSort(ArrayList<String> list, int digit)
    {
		ArrayList<String> temp = new ArrayList<>();
		stackQueue[] queue = new stackQueue[10];
		for(int c = 0; c < 10; c++) {
            queue[c] = new stackQueue();
        }
        for(int a = 0; a < list.size(); a++) {
            char huruf = list.get(a).charAt(digit);
            switch(huruf) {
				case '0' :
                    queue[0].enqueue(list.get(a));
                    break;
				case '1' :
                    queue[1].enqueue(list.get(a));
                    break;
				case '2' :
                    queue[2].enqueue(list.get(a));
                    break;
				case '3' :
                    queue[3].enqueue(list.get(a));
                    break;
				case '4' :
                    queue[4].enqueue(list.get(a));
                    break;
				case '5' :
                    queue[5].enqueue(list.get(a));
                    break;
				case '6' :
                    queue[6].enqueue(list.get(a));
                    break;
				case '7' :
                    queue[7].enqueue(list.get(a));
                    break;
				case '8' :
                    queue[8].enqueue(list.get(a));
                    break;
				case '9' :
                    queue[9].enqueue(list.get(a));
                    break;
            }
        }
		for(int b = 0; b < 10; b++) {
            while(!(queue[b].isEmpty())) {
                temp.add((String)queue[b].dequeue());
            }
        }
        return temp;
    }
}

/*
 *  Sumber : http://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks
 */
class stackQueue<E>
{
    private Stack<E> inbox = new Stack<E>();
    private Stack<E> outbox = new Stack<E>();

    public void enqueue(E item) 
	{
        inbox.push(item);
    }

    public E dequeue() 
	{
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
               outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }
    
    public boolean isEmpty()
    {
        return inbox.isEmpty();
    }
}