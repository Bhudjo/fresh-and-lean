package example

case class Cart(items: Map[String, Int]) {
  val namesToPrices = Map(
    "Bananas" -> 150,
    "Apples" -> 100,
    "Cherries" -> 75)

  val discounts = Map(
    "Cherries" -> (2, 20)
  )


  def total: Int = {
    val discount = items.map{ case (n, q) => {
      val (quant,disc) = discounts.getOrElse(n,(0,0))
      if(q >= quant) disc else 0
    }}.sum
    val total = items.map { case (n, q) => namesToPrices.getOrElse(n, 0) * q }.sum
    total - discount
  }

  def addProduct(productName: String): Cart = {
    val quantity = items.getOrElse(productName, 0) + 1
    Cart(items ++ Map(productName -> quantity))
  }

}

object Cart {
  def empty = Cart(Map.empty)
}