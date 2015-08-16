import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Ангелин on 13.08.2015.
 */
public class MyLinkedList<E> implements List<E> {
    private int size;
    private Element<E> header; // абстрактный эллемент списка, содержаший ссылку на первый и последний эллемент коллекции!
    // Относительно его будут производиться поиски, удаления и добавления эллементов!

    public MyLinkedList(){
        header = new Element(null, null, null);
        header.next = header.prev = header;
    }

    // Внутренний приватный класс для хранения текушего эллемента и ссылок на предыдуший и следуюший эллемент!!!
    private static class Element<E>{
        E element;
        Element<E> next;
        Element<E> prev;

        Element (E element, Element<E> next, Element<E> prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    // Внутренний метод находит нужный эллемент по индексу!!!
    private Element<E> getElement(int index){
        Element<E> e = header;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка!!!");
        }
        else if(index < (size >> 1)){
            for (int i = 0; i <= index; i++){
                e = e.next;
            }
        }
        else{
            for (int i = size; i > index; i--){
                e = e.prev;
            }
        }
        return e;
    }

    // Внутренный метод удаляет заданный эллемент(перераспределяет ссылки, заполняет значения эллемента null'ами)!
    private void deleteElement(Element<E> element){
        element.next.prev = element.prev;
        element.prev.next = element.next;
        element.element = null;
        element.next = null;
        element.prev = null;
        size--;
    }

    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public void add(int index, E e) {
        Element<E> element = (index == size ? header : getElement(index));
        Element<E> newElement = new Element(e, element, element.prev);
        newElement.next.prev = newElement;
        newElement.prev.next = newElement;
        size++;
    }

    @Override
    public boolean remove(Object obj) {
        Element<E> e = header;
        E el2 = (E) obj;
        for (int i = 0; i < size; i++) {
            e = e.next;
            if (e.element.equals(el2)) {
                deleteElement(e);
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        Element<E> rem = getElement(index);
        E el = rem.element;
        deleteElement(rem);
        return el;
    }

    @Override
    public E get(int index) {
        Element<E> e = getElement(index);
        return e.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return header.next==header;
    }

    @Override
    public boolean contains(Object obj) {
        Element<E> e = header;
        E elObj = (E) obj;
        for (int i = 0; i < size; i++) {
            e = e.next;
            if (e.element.equals(elObj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = size-1; i >= 0; i--){
            remove(i);
        }
        header.next = header.prev = header;
    }

    @Override
    public E set(int index, E element) {
        Element<E> el = getElement(index);
        E oldElement = el.element;
        el.element = element;
        return oldElement;
    }

    @Override
    public String toString() {
        String s = "";
        Element<E> e = header;
        for (int i = 0; i < size; i++) {
            e = e.next;
            s += " "+e.element;
        }
        return "MyLinkedList{" +
                s +" }";
    }





// Остальные дефолтные методы.
    @Override
    public Iterator<E> iterator() {
        return null;
    }
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public int indexOf(Object o) {
        return 0;
    }
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
