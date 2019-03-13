package com.example.nationalparks.model

import com.example.nationalparks.model.room.Park
import com.example.nationalparks.util.Weather
import java.time.LocalDate

class ParkRepository {

    val parks: List<Park>
    val desc = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quo modo autem optimum, si bonum praeterea nullum est? Rationis enim perfectio est virtus; Quae quo sunt excelsiores, eo dant clariora indicia naturae. Quis enim potest ea, quae probabilia videantur ei, non probare? Nonne videmus quanta perturbatio rerum omnium consequatur, quanta confusio? Itaque nostrum est-quod nostrum dico, artis est-ad ea principia, quae accepimus. </p>\n" +
            "\n" +
            "<p>Sic igitur in homine perfectio ista in eo potissimum, quod est optimum, id est in virtute, laudatur. An vero displicuit ea, quae tributa est animi virtutibus tanta praestantia? An est aliquid, quod te sua sponte delectet? </p>\n" +
            "\n" +
            "<p>Habes, inquam, Cato, formam eorum, de quibus loquor, philosophorum. Duo Reges: constructio interrete. Et quidem iure fortasse, sed tamen non gravissimum est testimonium multitudinis. Conclusum est enim contra Cyrenaicos satis acute, nihil ad Epicurum. In quo etsi est magnus, tamen nova pleraque et perpauca de moribus. Ne discipulum abducam, times. Bona autem corporis huic sunt, quod posterius posui, similiora. Non est ista, inquam, Piso, magna dissensio. </p>\n" +
            "\n" + "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quo modo autem optimum, si bonum praeterea nullum est? Rationis enim perfectio est virtus; Quae quo sunt excelsiores, eo dant clariora indicia naturae. Quis enim potest ea, quae probabilia videantur ei, non probare? Nonne videmus quanta perturbatio rerum omnium consequatur, quanta confusio? Itaque nostrum est-quod nostrum dico, artis est-ad ea principia, quae accepimus. </p>\n" +
            "\n" +
            "<p>Sic igitur in homine perfectio ista in eo potissimum, quod est optimum, id est in virtute, laudatur. An vero displicuit ea, quae tributa est animi virtutibus tanta praestantia? An est aliquid, quod te sua sponte delectet? </p>\n" +
            "\n" +
            "<p>Habes, inquam, Cato, formam eorum, de quibus loquor, philosophorum. Duo Reges: constructio interrete. Et quidem iure fortasse, sed tamen non gravissimum est testimonium multitudinis. Conclusum est enim contra Cyrenaicos satis acute, nihil ad Epicurum. In quo etsi est magnus, tamen nova pleraque et perpauca de moribus. Ne discipulum abducam, times. Bona autem corporis huic sunt, quod posterius posui, similiora. Non est ista, inquam, Piso, magna dissensio. </p>\n" +
            "\n"

    init {
        //parks = parkDao.getParks()
        parks = listOf(
            Park("GNP", "Test Park 1", "Test Location 1", LocalDate.of(2001,1,1), 1000, 50, desc),
            Park("GCNP", "Test Park 2", "Test Location 2", LocalDate.of(2002,2,2), 2000, 100, desc)
        )
    }

    fun getParkByCode(parkCode: String): Park {
        for (park in parks) {
            if (park.parkCode == parkCode) {
                return park
            }
        }
        return Park("","","", LocalDate.now(),0,0,"")
    }

    fun getWeatherByParkCode(parkCode: String): List<Weather> {
        //return weatherDao.getWeatherByParkCode(parkCode)
        return listOf(
            Weather("GNP",1,27,40,"snow"),
            Weather("GNP",2,31,43,"snow"),
            Weather("GNP",3,28,40,"partly cloudy"),
            Weather("GNP",4,24,34,"cloudy"),
            Weather("GNP",5,25,32,"snow")
        )
    }
}