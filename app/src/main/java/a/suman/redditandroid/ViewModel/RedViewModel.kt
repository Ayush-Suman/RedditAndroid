package a.suman.redditandroid.ViewModel

import a.suman.redditandroid.Data.Local.RedTable
import a.suman.redditandroid.Data.Repository
import android.app.Application
import android.util.Log.d
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class RedViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    private var redTable = MutableLiveData<List<RedTable>>()
    private val repository = Repository(application)
    private var disposable:Disposable?=null

    private val disposable2 = repository.loadDataLocal().subscribeOn(Schedulers.io()).subscribe {
        redTable.postValue(it)
    }

    val redData = redTable

    fun refresh( networkFail: networkFail){
    disposable =  repository.loadData().subscribeOn(Schedulers.io()).subscribe ({
        d("ViewModel", "Success")
        repository.insertDataLocal(it)},{ networkFail.Failed()})
    }



    override fun onCleared() {
        super.onCleared()
        if(disposable!=null){disposable!!.dispose()}
        disposable2.dispose()
    }
}

interface networkFail{
    fun Failed()
}