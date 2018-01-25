package example

import org.scalatest._

class CartSpec extends WordSpec with Matchers {
  "the cart" should {
    "give total" in {
      val cart = Cart.empty
      cart.addProduct("Bananas").total shouldEqual 150
    }
    "acceptance test iteration five-a" in {
      val cart = Cart.empty
        .addProduct("Mele")
        .addProduct("Pommes")
        .addProduct("Pommes")
        .addProduct("Mele")
      cart.total shouldEqual 250
      cart
        .addProduct("Bananas")
          .total shouldEqual 200
      Cart.empty
        .addProduct("Mele")
        .addProduct("Pommes")
        .addProduct("Pommes")
        .addProduct("Apples")
        .addProduct("Mele")
        .total shouldEqual 150
    }
  }
}
