import java.io.*;

class Student implements java.io.Serializable{

    String stu_name;
    int stu_age;
    int stu_id;

    public Student(String stu_name, int stu_age, int stu_id) {
        this.stu_name = stu_name;
        this.stu_age = stu_age;
        this.stu_id = stu_id;
    }
}
public class Main {
    public static void main(String[] args) {
        Student s=new Student("vikram",26,2);
        // s.stu_name="vikram";
        // s.stu_age=26;
        // s.stu_id=01;
        try{
            FileOutputStream fileOutputStream=new FileOutputStream("s.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(s);// converting object into byte stream or other format file like .txt
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("object serialized and saved in txt format="+objectOutputStream);
            //System.out.println("name="+s.stu_name);


            FileInputStream fileIn=new FileInputStream("s.txt");
            ObjectInputStream in=new ObjectInputStream(fileIn);
            s=(Student)in.readObject();// s.txt (it is data byte stream) is converted into object
            in.close();
            fileIn.close();
        }
        catch(IOException i){
            i.printStackTrace();

        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        System.out.println("deserialized student="+s);// s is the deserialized student(object)
        System.out.println("name="+s.stu_name);
    }
}