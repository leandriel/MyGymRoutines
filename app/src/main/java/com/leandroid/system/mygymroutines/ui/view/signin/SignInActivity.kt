package com.leandroid.system.mygymroutines.ui.view.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.leandroid.system.mygymroutines.R
import com.leandroid.system.mygymroutines.data.network.FirebaseSignInManager
import com.leandroid.system.mygymroutines.data.network.FirebaseSignInListener
import com.leandroid.system.mygymroutines.data.repository.auth.AuthRepository
import com.leandroid.system.mygymroutines.databinding.ActivitySignInBinding
import com.leandroid.system.mygymroutines.ui.view.home.HomeActivity
import com.leandroid.system.mygymroutines.ui.view.home.ProviderType
import com.leandroid.system.mygymroutines.utils.VisualUtils.Companion.showAlert

class SignInActivity : AppCompatActivity(), FirebaseSignInListener{
    private lateinit var binding: ActivitySignInBinding
    private val repository = AuthRepository(FirebaseSignInManager(this))
    private lateinit var viewModel: SignInViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
        initViewModel()

    }
    private fun initViewModel(){
        val viewModelFactory = SignInViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(SignInViewModel::class.java)
    }
    private fun setup() {
        title = "autenticación" // pasar string a el xml string
        with(binding) {
            btSignIn.setOnClickListener {
                if (etEmailSignIn.text.isNotEmpty() && etPassSignIn.text.isNotEmpty()) {
                    viewModel.login(etEmailSignIn.text.toString(),etPassSignIn.text.toString())
                }
            }
        }
    }
    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    override fun loginResult(isSuccess: Boolean) {
        if (isSuccess) {
            showHome(binding.etEmailSignIn.text.toString(), ProviderType.BASIC)
        } else {
            showAlert(
                this, getString(R.string.alert_title_attention),
                getString(R.string.alert_message_auth),
                getString(R.string.alert_accept_positive)
            )
        }
    }


}