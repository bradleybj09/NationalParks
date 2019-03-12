package com.example.nationalparks.model

import android.content.res.Resources
import android.icu.math.BigDecimal
import com.example.nationalparks.R
import com.example.nationalparks.model.room.Campground
import com.example.nationalparks.model.room.Park
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
            Park(1, "Test Park 1", "Test Location 1", LocalDate.of(2001,1,1), 1000, 50, desc),
            Park(2, "Test Park 2", "Test Location 2", LocalDate.of(2002,2,2), 2000, 100, desc)
        )
    }

    fun getParkById(parkId: Long): Park {
        for (park in parks) {
            if (park.parkId == parkId) {
                return park
            }
        }
        return Park(-1,"","", LocalDate.now(),0,0,"")
    }

    fun getCampgroundsByParkId(parkId: Long): List<Campground> {
        //return campgroundDao.getCampgroundsByParkId(parkId)
        return listOf(
            Campground(1, 1, "Test Campground 1", 1, 12, BigDecimal("35.00")),
            Campground(2, 1, "Test Campground 2", 5, 10, BigDecimal("35.00")),
            Campground(3, 2, "Test Campground 3", 1, 12, BigDecimal("20.00")),
            Campground(4, 2, "Test Campground 4", 6, 8, BigDecimal("20.00"))
        )
    }
}