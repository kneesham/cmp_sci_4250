#lang racket

(define pi 3.1416)

(define (my_area op radius)
  
  (cond
    [(negative? radius) #f]
    [(equal? op 1) (* pi (expt radius 2))]
    [(equal? op 2) (* 4/3 pi (expt radius 3)) ]
    [else #f]
    )
  )

(my_area 1 5)
(my_area 2 5)
(my_area 0 4)
(my_area 1 -2)
(my_area 2 -2)