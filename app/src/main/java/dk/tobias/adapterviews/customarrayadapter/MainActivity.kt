package dk.tobias.adapterviews.customarrayadapter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animalList=fillAnimalList()

        //Create the custom Array Adapter
        val myAdapter = AnimalAdapter(this, 0, animalList)

        //Set adapter of the ListView
        main_list_view.adapter = myAdapter
    }

    data class Animal(val name: String, val race: String, val gender: String ,val weight: String)

    class AnimalAdapter(context: Context, resource: Int, objects: MutableList<Animal>) :
        ArrayAdapter<Animal>(context, resource, objects){

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            //Get the view passed in the method parameter
            var listItemView = convertView

            //If view is null inflate it with the custom_list_item
            if (listItemView == null) {
                listItemView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false)
            }

            val animal = getItem(position)

            val textName = listItemView?.findViewById<TextView>(R.id.custom_list_item_name)
            textName?.text=animal.name

            val textRace = listItemView?.findViewById<TextView>(R.id.custom_list_item_race)
            textRace?.text=animal.race

            val textGender = listItemView?.findViewById<TextView>(R.id.custom_list_item_gender)
            textGender?.text=animal.gender

            val textWeight = listItemView?.findViewById<TextView>(R.id.custom_list_item_weight)
            textWeight?.text =animal.weight

            return listItemView as View
        }
    }

    private fun fillAnimalList(): ArrayList<Animal>{
        val animalList=ArrayList<Animal>()
        animalList.add(Animal("Lassie","Rough Collie","female", "24 kg"))
        animalList.add(Animal("Puss in boots","Tabby","male","6.1 kg"))
        return animalList
    }
}
