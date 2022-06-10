# Project Title

Basic PhoneBook.

## About

It is very basic PhoneBook, where you can add contacts to TreeMap.

## Author

* **Yhagni**

## License

This project is licensed under the MIT License. You can use it in the way you want!

## Main

int main(int argc, char *argv[]) {
    if(argc == 1) 
    {
        printf("Not enough arguments\n");
        return 9;
    }

    struct list_t *list = calloc(1, sizeof(struct list_t));

    if(list == NULL) 
    {
        printf("Failed to allocate memory\n");
        return 3;
    }

    for(int i = 1; i < argc; i++) 
    {
        int error = list_load_file(&list, *(argv+i));
        if(error == 2) {
            printf("Couldn't open file %s\n", *(argv+i));
        } else if(error == 3) {
            printf("Failed to allocate memory\n");
            list_free(list);
            return 3;
        }
    }
    
    list_display(list);
    list_free(list);

    return 0;
}

## linked_list.c

  #include "linked_list.h"

#include <malloc.h>
#include <string.h>

#define CREATE_BIT_COUNTER_FUNCTION(type)   \
uint8_t bit_counter_##type(type a) {        \
    uint8_t counter = 0;                    \
    while(a != 0) {                         \
        if(a & 1) {                         \
            counter++;                      \
        }                                   \
        a = a >> 1;                         \
    }                                       \
    return counter;                         \
}

#define HELPER_TABLE_SIZE 21

CREATE_BIT_COUNTER_FUNCTION(char);

struct node_t * create_node(char *text);
uint8_t word_bit_counter(char *word);

int list_load_file(struct list_t **list, const char *filename) {
    if(list == NULL || filename == NULL) {
        return 1;
    }

    if(*list == NULL) {
        *list = calloc(1, sizeof(struct list_t));
        if(*list == NULL) {
            return 3;
        }
    }

    FILE *input_file = fopen(filename, "r");
    if(input_file == NULL) {
        return 2;
    }

    char text[HELPER_TABLE_SIZE];
    
    while(!feof(input_file)) {
        memset(text, 0, HELPER_TABLE_SIZE); 
        fscanf(input_file, "%s", text);

        if((*list)->head == NULL) {
            (*list)->head = create_node(text);
            if((*list)->head == NULL) {
                return 3;
            }
            continue;
        }
        
        struct node_t *current_node = NULL;
        struct node_t *next_node = (*list)->head;
        int hit_flag = 0; 

        while(next_node != NULL) {
            current_node = next_node;
            next_node = current_node->next;

            if(strcmp(current_node->word->word, text) == 0) {
                current_node->word->counter++;
                hit_flag = 1;
                break;
            }
        }
        
        if(hit_flag == 0) {
            current_node->next = create_node(text);
            if(current_node->next == NULL) {
                return 3;
            }
        }
    }

    return 0;
}

struct node_t * create_node(char *text) {
    struct word_t *word = calloc(1, sizeof(struct word_t));
    if(word == NULL) {
        return NULL;
    }

    word->word = calloc(strlen(text) + 1, sizeof(char)); 
    if(word->word  == NULL) {
        free(word);
        return NULL;
    }

    strcpy(word->word, text);

    word->counter = 1;
    word->bit_counts = word_bit_counter(word->word);
            
    struct node_t *node = calloc(1, sizeof(struct node_t));
    if(node == NULL) {
        free(word->word);
        free(word);
        return NULL;
    }

    node->word = word;

    return node;
}

uint8_t word_bit_counter(char *word) {
    uint8_t bit_sum = 0;
    int word_size = strlen(word);
    
    for(int i = 0; i < word_size; i++) {
        bit_sum += bit_counter_char(*(word + i));
    }

    return bit_sum;
}


void list_display(const struct list_t *list) {
    struct node_t *current_node = list->head;

    while(current_node != NULL) {
        printf("%s %d %d\n", current_node->word->word, current_node->word->counter, current_node->word->bit_counts);
        current_node = current_node->next;
    }
}

void list_free(struct list_t *list) {
    if(list == NULL) {
        return;
    }

    if(list->head != NULL) {
        struct node_t *current_node = NULL;
        struct node_t *next_node = list->head;

        while(next_node != NULL) {
            current_node = next_node;
            next_node = current_node->next;

            free(current_node->word->word);
            free(current_node->word);
            free(current_node);
        }
    }

    free(list);
}

## linked_list.h

#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include <stdint.h>
#include <stdlib.h>

struct word_t 
{ 
 char *word; 
 uint8_t counter; 
 uint8_t bit_counts; 
};

struct node_t
{ 
 struct word_t *word; 
 struct node_t *next; 
};

struct list_t
{ 
 struct node_t *head; 
};

int list_load_file(struct list_t **list, const char *filename);
void list_free(struct list_t *list);
void list_display(const struct list_t *list);


#endif

