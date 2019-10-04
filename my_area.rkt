#lang racket
(define pi 3.1416)
(define (my_area op radius)
  
  (if (and (equal? op 1) (positive? radius))  (* pi (expt radius 2))
     
      (if (and (equal? op 2) (positive? radius)) (* 4/3 pi (expt radius 3) ) #f
          
  )))

(my_area 1 5)
(my_area 2 5)
(my_area 0 4)
(my_area 1 -2)
(my_area 2 -2)
