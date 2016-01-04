#include <stdio.h>
#include <math.h>
#include <stdlib.h>

typedef struct DoubleLinkedList {
	int data;
	struct DoubleLinkedList *next;
	struct DoubleLinkedList *previous;
} node;
void InsertDLLNode(node **head);
void DeleteNode(node **head, int position);
void PrintNodes(node *head);
/* This will create linked list.
 * The Algorithm checks if position exists in linked list and inserts node at position.
 * If position doesn't exist in linked list it appends node at the end
 */
void InsertDLLNode(node **head){
  node *newNode = (node*)malloc(sizeof(node));
  int value, position;
  // Always check for memory before creating a node
  if(!newNode){
	  printf("New Node cannot be created. Memory Error\n");
	  return;
  } else {
	  printf("Please enter the value and position of node\n");
	  scanf("%d %d", &value,&position);
	  newNode->data = value;
	  node *currentNode, *temp;
	  currentNode = *head;
	  // This will insert node at the beginning
	  if(position==1) {
		  printf("Inserting at beginning of List\n");
		  newNode->previous = NULL;
		  newNode->next = currentNode;
		  currentNode->previous = newNode;
		  *head = newNode;
	  } else {
		  int i;
		  while(i<position-1 && currentNode!=NULL){
			  i++;
			  temp = currentNode;
			  currentNode = currentNode->next;
		  }
		  // This will insert node at end in case if position doesn't exist
		  if(currentNode==NULL){
			  printf("Position doesn't exist in list.Inserting at end");
			  temp->next = newNode;
			  newNode->previous = temp;
			  newNode->next = NULL;
		  }
		  else{
			  temp->next = newNode;
			  newNode->previous = temp;
			  newNode->next = currentNode;
			  printf("Node has been inserted");
		  }
	  }
  }
}
