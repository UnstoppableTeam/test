package com.afanasyev;

import java.util.ArrayList;
import java.util.Collections;

public class List implements IList {
    private ListElement head;       // указатель на первый элемент
    private ListElement tail;       // указатель последний элемент

    @Override
    public void addFront(int data){    // добавление элеемнта
        ListElement a = new ListElement();
        a.data = data;

        if(head == null)
        {
            head = a;
            tail = a;
        }
        else {
            a.next = head;
            head = a;
        }
    }

    @Override
    public java.util.List nMaxElementSearch(int numberOfElements) { //получение n наибольших элементов списка
        ArrayList list = new ArrayList();
        ListElement t = head;
        while (t != null)
        {
            list.add(t.data);
            t = t.next;
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.subList(0, numberOfElements));
        return list.subList(0, numberOfElements);
    }

    @Override
    public void addBack(int data) {          //добавление в конец списка
        ListElement a = new ListElement();
        a.data = data;
        if (tail == null)
        {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    @Override
    public void printList() {               //печать списка
        ListElement t = head;
        while (t != null)
        {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    @Override
    public void delEl(int data) {  //удаление элемента
        if(head == null)
            return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        ListElement t = head;
        while (t.next != null) {
            if (t.next.data == data) {
                if(tail == t.next)
                {
                    tail = t;
                }
                t.next = t.next.next;
                return;
            }
            t = t.next;
        }
    }
}
