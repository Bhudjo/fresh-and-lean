package example

object Echo extends App {
  private val lines: Iterator[String] = io.Source.stdin.getLines
  val cart = Cart.empty
  for (productName <- lines) {
    val cartWithItem = cart.addProduct(productName)
    println(cartWithItem.total)
  }
}

