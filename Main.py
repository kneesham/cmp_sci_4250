###
# Name: Theodore Nesham
# Project: 4
# Date: 11/02/2019
# Description: This project was used to show inheritance, polymorphism, and encapsulation. The parent class is Product
#              and the two children classes are Book and Movie. The two subclasses override the print_description
#              function showing the use of polymorphism, as well as inherit functions and data members from product.
###


class Product:

    __name = "Product Name"
    __price = 0
    __discount_percent = 0

    def __init__(self, name, price, discount_percent):
        self.__name = name
        self.__price = price
        self.__discount_percent = discount_percent

    def get_name(self):
        return self.__name

    def get_discount_price(self):
        return round(self.__price - self.__price * self. __discount_percent, 2)

    def get_discount_amount(self):
        return round(self.__price * self.__discount_percent, 3)

    def print_description(self):
        print("Product name: " + self.__name
              + "\nDiscount: $" + str(self.get_discount_amount())
              + "\nPrice: $" + str(self.get_discount_price())
              + "\n")


class Book(Product):

    __author = ""

    def __init__(self, name, author, price, discount_percent):
        Product.__init__(self, name, price, discount_percent)  # calling the Parent constructor.
        self.__author = author

    def print_description(self):
        print("Book name: " + self.get_name()
              + "\nauthor: " + self.__author
              + "\ndiscount amount: $" + str(self.get_discount_amount())
              + "\nprice: $" + str(self.get_discount_price())
              + "\n"
              )


class Movie(Product):

    __year = ""

    def __init__(self, movie_name, year, price, discount_percent ):
        Product.__init__(self, movie_name, price, discount_percent)
        self.__year = year

    def print_description(self):
        print("Movie name: " + self.get_name()
              + "\nYear: " + str(self.__year)
              + "\ndiscount amount: $" + str(self.get_discount_amount())
              + "\nprice: $" + str(self.get_discount_price())
              + "\n"
              )


custom_product = Product("Popcorn", 4.99, 0.01)
batman_movie = Movie("Batman", 1999, 59.99, 0.05)
cool_book = Book("The Mythical Man Moth", "Frederick P. Brooks, JR.", 29.99, 0.01)

custom_product.print_description()
batman_movie.print_description()
cool_book.print_description()

