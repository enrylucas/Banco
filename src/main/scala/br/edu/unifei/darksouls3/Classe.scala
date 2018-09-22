package br.edu.unifei.darksouls3
import scala.slick.driver.PostgresDriver.simple._

class Classe(tag: Tag) extends Table[(String,Int,Int,Int,Int,Int)](tag,"classe") {
  def nome = column[String]("nome",O.PrimaryKey)
  def nivelInicial = column[Int]("nivelInicial")
  def forca = column[Int]("forca")
  def destreza = column[Int]("destreza")
  def inteligencia = column[Int]("inteligencia")
  def fe = column[Int]("fe")

  def * = (nome, nivelInicial, forca, destreza, inteligencia, fe)
}
