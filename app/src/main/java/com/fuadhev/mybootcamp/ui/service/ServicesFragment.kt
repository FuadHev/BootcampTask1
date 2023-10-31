package com.fuadhev.mybootcamp.ui.service



import androidx.navigation.fragment.findNavController
import com.fuadhev.mybootcamp.common.base.BaseFragment
import com.fuadhev.mybootcamp.databinding.FragmentServicesBinding
import com.fuadhev.mybootcamp.model.ServicesUiModel
import com.fuadhev.mybootcamp.ui.service.adapter.ServiceAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Handler


class ServicesFragment : BaseFragment<FragmentServicesBinding>(FragmentServicesBinding::inflate){

    private lateinit var serviceAdapter :ServiceAdapter

    override fun observeEvents() {

    }
    override fun onCreateFinish() {
        serviceAdapter= ServiceAdapter()

        serviceAdapter.submitList(arrayListOf(ServicesUiModel(1,"Əhali abonentinin enerji təchizatı şəbəkəsinə qoşulması","ehali"),
            ServicesUiModel(2,"Qoşulma Haqqının Onlayn Ödəlməsi","qosulma"),
            ServicesUiModel(4,"Borcun araşdırılması və borcun olmaması (və ya olması) barədə sənədin verilməsi","borc"),
            ServicesUiModel(3,"Kalkulyatorlar","kalkulyator"),
            ServicesUiModel(5,"Əhali istehlakçısının ad dəyişdirilməsi","ehaliistehlak"),
            ServicesUiModel(6,"Abonentin geniş tarixçəsinin verilməsi","abonent"),
            ServicesUiModel(7,"Yük hesabatının hazırlanması","yukhesabat"),
            ServicesUiModel(8,"İstehlakçının balansında olan elektrik şəbəkələrinə və avadanlıqlarına texniki xidmətin göstərilməsi","istehlakci")
        ))
        setAdapter()
   }

    private fun setAdapter(){
            binding.serviceRv.adapter=serviceAdapter
    }

}