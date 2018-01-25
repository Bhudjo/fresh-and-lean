package example

case class Cart(items: Map[String, Int]) {
  val namesToPrices = Map(
    "Bananas" -> 150,
    "Apples" -> 100,
    "Pommes" -> 100,
    "Mele" -> 100,
    "Cherries" -> 75)

  val discounts = Map(
    "Cherries" -> (2, 20),
    "Bananas" -> (2, 150),
    "Pommes" -> (3, 100),
    "Mele" -> (2, 50)
  )


  private def calculateFourAppleDiscount(items: Map[String, Int]) = {
    val apples = List("Apples", "Mele", "Pommes")
    val howManyApples = apples.flatMap(items.get).sum
    if(howManyApples>=4) 100 else 0
  }

  def calculateFiveFruitsDiscount(items: Map[String, Int]): Int = {
    val totalNumberOfItems = items.toList.unzip._2.sum
    if(totalNumberOfItems>=5) 200 else 0
  }

  def total: Int = {
    val discount = calculateStandardCartDiscount
    val fourApplesDiscount = calculateFourAppleDiscount(items)
    val fiveFruitsDiscount = calculateFiveFruitsDiscount(items)
    val total = items.map { case (n, q) => namesToPrices.getOrElse(n, 0) * q }.sum
    total - discount - fourApplesDiscount - fiveFruitsDiscount
  }

  private def calculateStandardCartDiscount = {
    items.map { case (itemName, quantityInCart) =>
      val (quantityToGetDiscount, discountValue) = discounts.getOrElse(itemName, (0, 0))
      if (quantityInCart >= quantityToGetDiscount) discountValue else 0
    }.sum
  }

  def addProduct(productName: String): Cart = {
    val quantity = items.getOrElse(productName, 0) + 1
    Cart(items ++ Map(productName -> quantity))
  }

}

object Cart {
  def empty = Cart(Map.empty)
}