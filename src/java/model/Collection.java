/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thinh
 */
public class Collection {
    private String CollectionID;
    private String AccountID;
    private String Name;
    private int NumberOfQuestion;

    public Collection() {
    }

    public Collection(String CollectionID, String AccountID, String Name, int NumberOfQuestion) {
        this.CollectionID = CollectionID;
        this.AccountID = AccountID;
        this.Name = Name;
        this.NumberOfQuestion = NumberOfQuestion;
    }

    public String getCollectionID() {
        return CollectionID;
    }

    public void setCollectionID(String CollectionID) {
        this.CollectionID = CollectionID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getNumberOfQuestion() {
        return NumberOfQuestion;
    }

    public void setNumberOfQuestion(int NumberOfQuestion) {
        this.NumberOfQuestion = NumberOfQuestion;
    }

    @Override
    public String toString() {
        return "Collection{" + "CollectionID=" + CollectionID + ", AccountID=" + AccountID + ", Name=" + Name + ", NumberOfQuestion=" + NumberOfQuestion + '}';
    }
    
    

}
