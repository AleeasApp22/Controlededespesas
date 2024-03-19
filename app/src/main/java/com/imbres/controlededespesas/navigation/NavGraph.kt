package com.imbres.controlededespesas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imbres.controlededespesas.SplashScreen
import com.imbres.controlededespesas.app.ControleScreen
import com.imbres.controlededespesas.data.login.LoginViewModel
import com.imbres.controlededespesas.data.lostpassword.LostPasswordViewModel
import com.imbres.controlededespesas.data.model.CategoryParam
import com.imbres.controlededespesas.data.newexpense.NewExpenseViewModel
import com.imbres.controlededespesas.data.signup.SignupViewModel
import com.imbres.controlededespesas.screeens.HomeScreen
import com.imbres.controlededespesas.screeens.LoginScreen
import com.imbres.controlededespesas.screeens.LostPasswordScreen
import com.imbres.controlededespesas.screeens.NewExpenseScreen
import com.imbres.controlededespesas.screeens.SignUpScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    val categories = listOf(
        "Padaria, lanches, bebidas",
        "Empréstimos, tarifas, taxas, IR e impostos",
        "Despesas com transporte (Combustível, Sem Parar, oficina, licenciamento)",
        "NÃO CONTABILIZADO",
        "Internet, Celular, TV, site, spotify, hospedagem digital, impressora, email",
        "Vestuário, ensino, cuidados",
        "Supermercado, sacolão, açougue, feira",
        "Seguros",
        "Cacao",
        "Saúde (Unimed, Uniodonto, Medicamentos)",
        "EDP, Sabesp, gás, IPTU, empregada, manutenção casa",
        "Outros gastos"
    )

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Controle.route) {
            ControleScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.LostPassword.route) {
            LostPasswordScreen(navController = navController)
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.NewExpense.route) {
            NewExpenseScreen(navController = navController, categoryParam = CategoryParam())
        }
    }
}
