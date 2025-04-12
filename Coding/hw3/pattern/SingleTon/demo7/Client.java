
// 通过序列化破坏singleTon模式
pubic class Client{
    public static void main(String[] args) throws Exception{
        readObjectFromFile();
        readObjectFromFile();
    }

    public static void readObjectFromFile() throws Exception {
        // Creat stream
        ObjectInputStream ois = new ObjectInputStream(new FileOutputStream("D:\\ChuwaJavaWorkspace\\Chuwa20241209\\Coding\\hw3\\pattern\\SingleTon\\a.txt"));
        // read object
        SingleTon instance = (SingleTon)ois.readObject();

        //System.out.println(instance);

        // release resource
        ois.close();
    }

    public static void writeObject2File() throws Exception {
        // Get singleton instance
        SingleTon instance = SingleTon.getInstance();
        // Creat output stream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\ChuwaJavaWorkspace\\Chuwa20241209\\Coding\\hw3\\pattern\\SingleTon\\a.txt"));

        // write object
        oos.writeObject(instance);

        // release resource
        oos.close();
    }
}