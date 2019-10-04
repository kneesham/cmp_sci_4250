#lang racket
(define (my_delete atom lst)
  [cond
    ([null? lst] lst)
    ([pair? (car lst)]
         (cons (my_delete atom (car lst)) (my_delete atom (cdr lst))))
    ([eqv? (car lst) atom]
         (my_delete atom [cdr lst])) ;; equal value delete form list, else change positinon of last[0]
    (else
         (cons (car lst) (my_delete atom (cdr lst))))
    ]
  )
(my_delete 'a  '( c d e (a b (a b (a b (a b a b a)))) a a))
