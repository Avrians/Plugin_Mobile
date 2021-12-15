fun main(){

    //soal 1
    for (a in 1..4) {
        for (b in 1..a) {
            print(" $b")
        }
        print("\n")
    }

    //soal 2
    var nilai = 2
    var pangkat = 5
    var hasil: Double
    hasil = Math.pow(nilai.toDouble(), pangkat.toDouble())
    println("\nhasil dari $nilai pangkat $pangkat\n"+hasil)

}
