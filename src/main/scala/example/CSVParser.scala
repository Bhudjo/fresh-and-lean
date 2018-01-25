package example

object CSVParser extends App {
  val cart = Cart.empty
  private val lines: Iterator[String] = io.Source.stdin.getLines
  for (productsName <- lines) {
    val products = productsName.split(",").toList
    val cartWithItem = products.foldLeft(cart)((c, p) => c.addProduct(p))
    println(cartWithItem.total)
  }
}