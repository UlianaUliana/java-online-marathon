//Suppose we have the next class:
//
//  class NameList {
//      private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};
//
//      public Iterator getIterator() {
//          return new Iterator();
//      }
//  }
//Create public inner class named Iterator inside NameList class that correspond the next class diagram:

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter;
        private Iterator(){
            this.counter = 0;
        }
        public boolean hasNext() {
            try {
                next();
            } catch (Exception e) {
                return false;
            }
            counter--;
            return true;
        }
        public String next() {
            counter++;
            return names[counter - 1];
        }
    }

}
