class FixedQueue implements ICharQ {
    private char q[];
    private int putloc, getloc;
    public FixedQueue(int size) {
        q=new char[size];
        putloc=getloc=0;
    }
    public void put(char ch) {
       if (putloc == q.length) {
            System.out.println("Очередь запол-на");
            return;
       }
       q[putloc++]=ch;
    }

        @Override
        public char get() {
            if(getloc==putloc) {
                System.out.println("Очередь пуста!");
                return (char) 0;
            }
            return q[getloc++];
        }
    }
class CircularQueue implements ICharQ {
    private char q[];
    private int putloc,getloc;
    public CircularQueue(int size) {
        q=new char[size+1];
        putloc=getloc=0;
    }
    public void put(char ch) {
        if(putloc+1==getloc | ((putloc==q.length-1) & getloc==0)) {
            System.out.println("Очередь заполнена!");
            return;
        }
        q[putloc++]=ch;
        if(putloc==q.length) putloc=0;
    }
    public char get() {
        if(getloc==putloc) {
            System.out.println("Очередь пуста!");
            return(char) 0;
        }
        char ch=q[getloc++];
        if(getloc==q.length) getloc=0;
        return q[getloc];
    }
}

class DynQueue implements ICharQ {
    private char q[];
    private int putloc, getloc;
    public DynQueue(int size) {
        q=new char[size];
        putloc=getloc=0;
    }
    public void put(char ch) {
        if(putloc==q.length) {
            char t[]=new char[q.length*2];
            for(int i=0;i<q.length;i++)
                t[i]=q[i];
            q=t;
        }
        q[putloc++]=ch;
    }
    public char get() {
        if(getloc==putloc) {
            System.out.println("Очередь пуста");
            return (char) 0;
        }
        return q[getloc++];
    }
}
class IQDemo{
    public static void main(String args[]) {
        FixedQueue q1=new FixedQueue(10);
        DynQueue q2=new DynQueue(5);
        CircularQueue q3=new CircularQueue(10);
        ICharQ iQ;
        char ch;
        int i;
        iQ=q1;
        for(i=0;i<10;i++)
            iQ.put((char)('A'+i));
        System.out.println("Содержимое фиксированной q:");
        for(i=0;i<10;i++){
            ch=iQ.get();
            System.out.print(ch);
        }
        System.out.println();

        iQ=q2;
        for(i=0;i<10;i++)
            iQ.put((char) ('Z'-i));

        System.out.println("Содержимое динамической q.:");
        for(i=0;i<10;i++){
            ch=iQ.get();
            System.out.print(ch);
        }
        System.out.println();
        iQ=q3;
        for(i=0;i<10;i++)
            iQ.put((char)('A'+i));
        System.out.println("Содержимое кольцевой очереди:");
        for(i=0;i<10;i++){
            ch=iQ.get();
            System.out.print(ch);
        }
        System.out.println();
        for(i=10;i<20;i++){
            iQ.put((char)('A'+i));
        }
        System.out.println("Содержимое кольцевой q:");
        for(i=0;i<10;i++){
            ch=iQ.get();
            System.out.print(ch);
        }
        System.out.println("\nСохр-е и исп-е данных кольцевой q.");
        for(i=0;i<20;i++){
            iQ.put((char)('A'+i));
            ch=iQ.get();
            System.out.print(ch);
        }
    }
}