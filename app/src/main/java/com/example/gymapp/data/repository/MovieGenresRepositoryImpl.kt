package com.example.gymapp.data.repository

import com.example.gymapp.data.remote.MovieGenresApi
import com.example.gymapp.domain.MovieRepository
import com.example.gymapp.domain.model.AllMovieGenres
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieGenresApi: MovieGenresApi,
) : MovieRepository {


    override suspend fun getAllMovieGenres(): Flow<Resource<AllMovieGenres>> = flow {
        emit(Resource.Loading())
        try {
            val response = movieGenresApi.getAllMovieGenres()
            emit(Resource.Success(data = response))
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = e.message.toString(),
            ))

        } catch (e: IOException) {
            emit(Resource.Error(
                message = e.message.toString(),
            ))
        }
    }


    override suspend fun getOneMovieGenresById(id: String): Flow<Resource<MovieGenres>> = flow {
        emit(Resource.Loading())
        try {
            val response = movieGenresApi.getOneMovieGenres(id)
            emit(Resource.Success(data = response))
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = e.message.toString(),
            ))

        } catch (e: IOException) {
            emit(Resource.Error(
                message = e.message.toString(),
            ))
        }
    }


//    override suspend fun getOneMovie(id: String): Flow<Resource<MovieGenres>> = flow {
//        emit(Resource.Loading())
//        try {
//            val response = movieGenresApi.getOneMovieGenres(id)
//            emit(Resource.Success(data = response))
//        } catch (e: HttpException) {
//            emit(Resource.Error(
//                message = e.message.toString(),
//            ))
//
//        } catch (e: IOException) {
//            emit(Resource.Error(
//                message = e.message.toString(),
//            ))
//        }
//    }



//    override suspend fun login(authToken: String): FUser {
//        return fruityApi.login(authToken = authToken)
//    }
//
//    override suspend fun addToCart(authToken: String, item: CartAdd) =
//        fruityApi.addToCart(authToken, item)
//
//    override suspend fun getIdToken(): String = withContext(Dispatchers.Unconfined) {
//        Log.d("getIdTokenReWith: ", "Token")
//        val user = Firebase.auth.currentUser
//        user?.getIdToken(true)?.addOnSuccessListener {
//            Log.d("getIdToken: ", "User${user.displayName}")
//        }.let { withContext(Dispatchers.Unconfined) { it?.result?.token.toString() } }
//    }
//
//    override suspend fun removeFromCart(authToken: String, item: RemoveProduct) {
//        fruityApi.deleteFromCart(authToken = authToken, item = item)
//    }
//
//    override suspend fun signup(signup: SignupUser) = flow {
//        emit(Resource.Loading())
//        try {
//            val response = fruityApi.signup(signup)
//            emit(Resource.Success(data = response))
//
//        } catch (e: HttpException) {
//            emit(Resource.Error(
//                message = e.message.toString(),
//            ))
//        } catch (e: IOException) {
//            emit(Resource.Error(
//                message = e.message.toString(),
//            ))
//        }
//    }
//
//    override suspend fun loginUser(loginCredentials: LoginCredentials): Flow<Resource<LoginResult>> =
//        flow {
//            emit(Resource.Loading())
//            try {
//                val response = fruityApi.loginUser(loginCredentials)
//                emit(Resource.Success(data = response))
//            } catch (e: HttpException) {
//                emit(Resource.Error(
//                    message = e.message.toString(),
//                ))
//            } catch (e: IOException) {
//                emit(Resource.Error(
//                    message = "Couldn't reach server, check your internet connection.",
//                ))
//            }
//        }
}