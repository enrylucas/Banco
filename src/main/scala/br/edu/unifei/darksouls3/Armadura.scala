package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._


class Armadura(tag: Tag) extends Table[(String,Float,Float,Int,Int,Boolean)](tag,"armadura"){
  def nome = column[String]("nome",O.PrimaryKey)
  def peso = column[Float]("peso")
  def durabilidade = column[Float]("durabilidade")
  def defesaFisica = column[Int]("defesaFisica")
  def defesaMagica = column[Int]("defesaMagica")
  def quebrado = column[Boolean]("quebrado")

  def * = (nome, peso, durabilidade, defesaFisica, defesaMagica, quebrado)


}
