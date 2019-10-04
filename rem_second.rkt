#lang racket
(define (rem_second list)
  (cons (car list) (cdr (cdr list)))  
  )
(rem_second '(1 (2 3) 3 4))