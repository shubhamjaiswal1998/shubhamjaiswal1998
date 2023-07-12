package core_jdbc1;


class Person {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


public class java_testQ3 {
	 public static void main(String[] args) {
	        Person person = new Person();
	        person.setName("shubham jaiswal");
	        person.setAge(25);
	        person.setAddress("lucknow, City");

	        System.out.println("name " + person.getName());
	        System.out.println("age " + person.getAge());
	        System.out.println("address " + person.getAddress());
	    }

}
