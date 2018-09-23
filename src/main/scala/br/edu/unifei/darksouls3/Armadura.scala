package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._


class Armadura(tag: Tag) extends Table[(String,Int,Int,Int,Int,Boolean, Categoria.Value)](tag,"armadura"){
  def nome = column[String]("nome",O.PrimaryKey)
  def peso = column[Int]("peso")
  def durabilidade = column[Int]("durabilidade")
  def defesaFisica = column[Int]("defesaFisica")
  def defesaMagica = column[Int]("defesaMagica")
  def quebrado = column[Boolean]("quebrado")
  def categoria = column[Categoria.Value]("categoria")

  def * = (nome, peso, durabilidade, defesaFisica, defesaMagica, quebrado, categoria)


}
