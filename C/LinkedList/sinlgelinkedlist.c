#include <stdio.h>
#include <math.h>
#include <stdlib.h>

typedef struct LinkedList {
	int data;
	struct LinkedList *next;
} node;
void InsertNode(node **head);
void DeleteNode(node **head, int position);
void PrintNodes(node *head);
int SearchNode(node *head);

/* This will create linked list.
 * The Algorithm checks if position exists in linked list and inserts node at position.
 * If position doesn't exist in linked list it appends node at the end
 */
void InsertNode(node **head){
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
		  newNode->next = currentNode;
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
			  newNode->next = NULL;
		  }
		  else{
			  temp->next = newNode;
			  newNode->next = currentNode;
			  printf("Node has been inserted");
		  }
	  }
  }
}
/* This algorithm deletes node from linked list given position of node.
 * If position is not present in linked list then nothing will be deleted.
 */
void DeleteNode(node **head, int position){
	node *currentNode = *head;
	node *temp;
	int i;
	if(currentNode==NULL){
		printf("List is empty");
		return;
	} else{
		if(position==1){
			printf("Deleting node after head");
			*head = currentNode->next;
			free(currentNode);
		}else{
			while(currentNode!=NULL && i<position-1){
				temp = currentNode;
				currentNode = currentNode->next;
				i++;
			}
			if(!currentNode){
				printf("Position doesn't exist in list");
				return;
			}else{
				temp->next=currentNode->next;
				free(currentNode);
			}
		}
	}
}

/* This algorithm will print all nodes of linked list
 * prints empty list if head is null
 */
void PrintNodes(node *head){
	if(head==NULL){
		printf("List is Empty");
	} else {
		node *currentNode = head;
		while (currentNode != NULL)
		  {
			 printf(" %d ", currentNode->data);
			 currentNode = currentNode->next;
		  }
	}
}
void PrintSortedNodes(){
	printf("Print Sorted Nodes is called\n");
}
int SearchNode(node *head){
	printf("Search Node is called\n");
}
int main(){
	node *head = NULL;
	int input,deleteInput, position;
	do{
		printf("Please enter an Input to continue\n1: Insert Node \n2: Delete Node \n3: Print Nodes\n4: Print Sorted Nodes\n5: Search Nodes\n6:Exit");
		scanf("%d", &input);
		switch(input) {
			case 1:
				InsertNode(&head);
				break;
			case 2:
				printf("Please enter an Input to continue\n1: Delete Node from position \n2: Search node and delete Node");
				scanf("%d", &deleteInput);
				if(deleteInput==1){
					printf("Enter position of node to be deleted");
					scanf("%d", &position);
					DeleteNode(&head, position);
				}else{
					position = SearchNode(head);
					if(position!=-1){
						DeleteNode(&head, position);
					}
				}
				break;
			case 3:
				PrintNodes(head);
				break;
			case 4:
				PrintSortedNodes();
				break;
			case 5:
				position = SearchNode(head);
				break;
			case 6:
				printf("No more operations to be done.Exiting\n");
			default:
				InsertNode(&head);
				break;
		}
	}while(input!=6);
	return 0;
}




