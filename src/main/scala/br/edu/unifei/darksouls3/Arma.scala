package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

class Arma(tag: Tag) extends Table[(String,Int,Int,Int,Int,Boolean,Categoria.Value)](tag,"arma"){
  def nome = column[String]("nome",O.PrimaryKey)
  def peso = column[Int]("peso")
  def durabilidade = column[Int]("durabilidade")
  def ataqueFisico = column[Int]("ataqueFisico")
  def ataqueMagico = column[Int]("ataqueMagico")
  def quebrado = column[Boolean]("quebrado")
  def categoria = column[Categoria.Value]("categoria")

  def * = (nome,peso,durabilidade,ataqueFisico,ataqueMagico,quebrado,categoria)
}