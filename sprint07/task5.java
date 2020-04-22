//Create class hierarchy that represent Address Book, where can be save records in format:
// "(first name, last name) => address":
//
//Records in the Addres Book should be represented as objects of the NameAddressPair type.
//The pair "(first name, last name)" is key for access to "address" in the Address Book.
//The key "(first name, last name)" should be immuteble and in Address Book cannot be
// two records with same key.
//The capacity of Address Book must grow twice when has no place for save the next record.
//The sortedBy(...) method should sorted records by ascending or descending using for
// this Arrays.sort(...) method.
//The Comparator should be implemented as an anonymous class.
//Sorting at first be by firstName field, and if the names match then by lastName field.
//The next() method from AddressBookIterator class should return record as String
// in next format: "First name: <first name>, Last name: <last name>, Address: <address>".
//A class hierarchy should be correspond the next class diagram:
//
//* If you see the next error: uses unchecked or unsafe operations, just put the next code line 
//@SuppressWarnings("unchecked") over AddressBook and AddressBookIterator classes.


class AddressBook implements Iterable{
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        if (counter == addressBook.length - 1) {
            NameAddressPair[] addressBookNew = new NameAddressPair[addressBook.length * 2];
            for(int i = 0; i < addressBook.length; i++) {
                addressBookNew[i] = addressBook[i];
            }
//            addressBook = addressBookNew;
        }
        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        for(int i = 0; i < counter; i++){
            if (addressBook[i].person.equals(newPerson)){
                return false;
            }
        }
        addressBook[counter] = new NameAddressPair(newPerson, address);
        counter++;
        return true;
    }
    public String read(String firstName, String lastName) {
        NameAddressPair.Person keyPerson = new NameAddressPair.Person(firstName, lastName);
        String result = "";
        for(NameAddressPair record : addressBook) {
            if (record.person.equals(keyPerson)){
                return record.address;
            } else {
                result = null;
            }
        }
        return result;
    }
    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person personToUpdate = new NameAddressPair.Person(firstName, lastName);
        for(NameAddressPair record : addressBook) {
            if (record.person.equals(personToUpdate)){
                record.address = address;
                return true;
            }
        }
        return false;

    }
    public boolean delete(String firstName, String lastName){
        NameAddressPair.Person personToDelete = new NameAddressPair.Person(firstName, lastName);
        for(int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(personToDelete)) {
                NameAddressPair[] addressBookNew = new NameAddressPair[counter--];
                for(int j = 0; j < i; j++) {
                    addressBookNew[j] = addressBook[j];
                }
                for (int j = i; j < counter; j++) {
                    addressBookNew[j] = addressBook[j+1];
                }
//                addressBook = addressBookNew;
                return true;
            }
        }
        return false;
    }
    public int size() {
        return counter;
    }
    public void sortedBy(SortOrder sortOrder){
        switch (sortOrder) {
            case ASC:
                Arrays.sort(addressBook, new Comparator<NameAddressPair>(){
                    @Override
                    public int compare(NameAddressPair o1, NameAddressPair o2) {
                        if(o1.person.firstName == o2.person.firstName) {
                            return o1.person.lastName.compareTo(o2.person.lastName);
                        } else {
                            return o1.person.firstName.compareTo(o2.person.firstName);
                        }
                    }
                });
                break;
            case DESC:
                Arrays.sort(addressBook, new Comparator<NameAddressPair>(){
                    @Override
                    public int compare(NameAddressPair o1, NameAddressPair o2) {
                        if(o1.person.firstName == o2.person.firstName) {
                            return o2.person.lastName.compareTo(o1.person.lastName);
                        } else {
                            return o2.person.firstName.compareTo(o1.person.firstName);
                        }
                    }
                });
                break;
        }

    }
    public Iterator iterator() {
        return new AddressBookIterator();
    }
    private static class NameAddressPair {
        private final Person person;
        private String address;
        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }
        private static class Person {
            private String firstName;
            private String lastName;
            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }
            @Override
            public boolean equals(Object object){
                if (this == object) return true;
                if (object == null || this.getClass() != object.getClass()) return false;
                Person person = (Person) object;
                return firstName.equals(person.firstName) && lastName.equals(person.lastName);
            }
            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + firstName == null ? 0 : firstName.hashCode();
                result = prime * result + lastName == null ? 0 : lastName.hashCode();
                return result;
            }
        }
    }
    private class AddressBookIterator implements Iterator {
        private int counter = 0;
        public boolean hasNext() {
            return counter < size();
        }
        public String next() {
            return "First name: " + addressBook[counter].person.firstName + ", Last name: " + addressBook[counter].person.lastName + ", Address: " + addressBook[counter++].address;
        }
    }

}
enum SortOrder {
    ASC, DESC
}
