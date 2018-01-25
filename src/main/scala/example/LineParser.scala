package example

object LineParser extends App {
  val cart = Cart.empty
  private val lines: Iterator[String] = io.Source.stdin.getLines
  for (productName <- lines) {
    val cartWithItem = cart.addProduct(productName)
    println(cartWithItem.total)
  }
}

