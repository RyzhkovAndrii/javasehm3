import java.util.ArrayList;
import java.util.List;

class IntCollection {

    private List<Integer> intList;

    public IntCollection() {
        intList = new ArrayList<>();
    }

    public IntCollection(int initialCapacity) throws CustomNegativeException {
        if (initialCapacity < 0) {
            throw new CustomNegativeException("Initial capacity is negative!");
        }
        intList = new ArrayList<>(initialCapacity);
    }

    public IntCollection(IntCollection intCollection) throws CustomNullException {
        if (intCollection == null) {
            throw new CustomNullException("Collection is null!");
        }
        intList = new ArrayList<>(intCollection.size());
        for (int i = 0; i < intCollection.size(); i++) {
            try {
                intList.add(intCollection.get(i));
            } catch (CustomIndexException ignore) {
                // custom index exception doesn't throw in this case
            }
        }
    }

    private int size() {
        return intList.size();
    }

    private boolean isEmpty() {
        return this.size() == 0;
    }

    private void increaseElementsValue(int value) {
        for (int i = 0; i < intList.size(); i++) {
            intList.set(i, intList.get(i) + value);
        }
    }

    private void decreaseElementsValue(int value) {
        for (int i = 0; i < intList.size(); i++) {
            intList.set(i, intList.get(i) - value);
        }
    }

    public void add(Integer element) throws CustomNullException {
        if (element == null) {
            throw new CustomNullException("Element is null!");
        }
        this.increaseElementsValue(element);
        intList.add(element);
    }

    public Integer removeByIndex(int index) throws CustomIndexException {
        if (index < 0 || index >= intList.size()) {
            throw new CustomIndexException("Index is out of bounds!");
        }
        Integer value = intList.remove(index);
        this.decreaseElementsValue(value);
        return value;
    }

    public boolean removeByValue(Integer value) throws CustomNullException {
        if (value == null) {
            throw new CustomNullException("Value is null!");
        }
        if (intList.remove(value)) {
            this.decreaseElementsValue(value);
            return true;
        }
        return false;
    }

    public Integer get(int index) throws CustomIndexException {
        if (index < 0 || index >= intList.size()) {
            throw new CustomIndexException("Index is out of bounds!");
        }
        return intList.get(index);
    }

    public int indexOf(Integer value) throws CustomNullException {
        if (value == null) {
            throw new CustomNullException("Value is null!");
        }
        return intList.indexOf(value);
    }

    public Integer getMaximal() {
        if (this.isEmpty()) {
            return null;
        }
        int maximal = Integer.MIN_VALUE;
        for (Integer element : intList) {
            if (element > maximal) {
                maximal = element;
            }
        }
        return maximal;
    }

    public Integer getMinimal() {
        if (this.isEmpty()) {
            return null;
        }
        int minimal = Integer.MAX_VALUE;
        for (Integer element : intList) {
            if (element < minimal) {
                minimal = element;
            }
        }
        return minimal;
    }

    public Double getAverage() {
        if (this.isEmpty()) {
            return null;
        }
        double average = 0.0;
        for (Integer element : intList) {
            average += element;
        }
        return average / intList.size();
    }

}
