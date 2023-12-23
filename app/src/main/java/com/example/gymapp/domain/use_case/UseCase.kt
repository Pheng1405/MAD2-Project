package com.example.gymapp.domain.use_case

data class UseCases(
    val getAllMovieGenresUseCase: GetAllMovieGenresUseCase,

    val getOneMovieGenresUseCase: GetOneMovieGenresUseCase,
    val signInUseCase: SignInUseCase,
    val getAllMovieUseCase: GetAllMovieUseCase,
    val getOneMovieUseCase: GetOneMovieUseCase,

//    val getCartUseCase: GetCartUseCase,
//    val getCartUseCase: GetCartUseCase,
//    val getAllProductsUseCase: GetAllProductsUseCase,
//    val loginUseCase: LoginUseCase,
//    val addToCartUseCase: AddToCartUseCase,
//    val getIdToken: GetIdToken,
//    val removeCartUseCase: RemoveCartUseCase,
//    val signupUseCase: SignupUseCase
)