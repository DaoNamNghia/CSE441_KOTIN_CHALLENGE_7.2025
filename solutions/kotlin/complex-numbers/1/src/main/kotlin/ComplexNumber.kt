import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0)

operator fun ComplexNumber.plus(other: ComplexNumber): ComplexNumber =
    ComplexNumber(
        real = this.real + other.real,
        imag = this.imag + other.imag
    )

operator fun ComplexNumber.minus(other: ComplexNumber): ComplexNumber =
    ComplexNumber(
        real = this.real - other.real,
        imag = this.imag - other.imag
    )

operator fun ComplexNumber.times(other: ComplexNumber): ComplexNumber =
    ComplexNumber(
        real = this.real * other.real - this.imag * other.imag,
        imag = this.real * other.imag + this.imag * other.real
    )

operator fun ComplexNumber.div(other: ComplexNumber): ComplexNumber =
    ComplexNumber(
        real = (this.real * other.real + this.imag * other.imag)
            / (other.real.pow(2) + other.imag.pow(2)),
        imag = (this.imag * other.real - this.real * other.imag)
            / (other.real.pow(2) + other.imag.pow(2))
    )

val ComplexNumber.abs: Double
  get() = sqrt(real.pow(2) + imag.pow(2))

fun ComplexNumber.conjugate(): ComplexNumber =
    copy(imag = (-1) * imag)

fun exponential(exponent: ComplexNumber): ComplexNumber =
    ComplexNumber(
        real = exp(exponent.real) * cos(exponent.imag),
        imag = exp(exponent.real) * sin(exponent.imag)
    )