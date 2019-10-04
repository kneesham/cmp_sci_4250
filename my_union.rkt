#lang racket
(define ( my_union set1 set2)
  
  [cond
    ([null? set1] set2)
    ([null? set2] set1)
    ([equal? set1 set2] set1)
    
    ([member (car set2) set1]
        (my_union set1 [cdr set2]))
    (else
     (my_union [cons (car set2) set1] [cdr set2]))
    ] 
  )

(my_union '(1 2 3 4 5) '(1 2 3 4 5 6))
(my_union '(1 2 3 4 5) '(1 2 3 4 5))