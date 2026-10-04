package com.example.actidad_en_clase.composables



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Perfil() {

    // Datos del perfil
    var nombre by remember { mutableStateOf("") }
    var carrera by remember { mutableStateOf("") }
    var semestre by remember { mutableIntStateOf(0) }

    // Contador de Me gusta
    var likes by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Título
            Text(
                text = "Mi Ficha",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            // Avatar
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .background(
                        color = Color.LightGray,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = nombre.firstOrNull()?.uppercase() ?: "",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Nombre en el perfil
            Text(
                text = nombre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            // Carrera en el perfil
            Text(
                text = carrera,
                fontSize = 16.sp
            )

            // Semestre en el perfil
            if (semestre > 0) {
                Text(
                    text = "$semestre° Semestre",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Campo Nombre
            OutlinedTextField(
                value = nombre,
                onValueChange = {
                    nombre = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Nombre")
                },
                placeholder = {
                    Text("Nombre completo")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo Carrera
            OutlinedTextField(
                value = carrera,
                onValueChange = {
                    carrera = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Carrera")
                },
                placeholder = {
                    Text("Carrera actual")
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Selección de semestre
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = {
                        semestre = 1
                    }
                ) {
                    Text("1°")
                }

                Button(
                    onClick = {
                        semestre = 2
                    }
                ) {
                    Text("2°")
                }

                Button(
                    onClick = {
                        semestre = 3
                    }
                ) {
                    Text("3°")
                }

                Button(
                    onClick = {
                        semestre = 4
                    }
                ) {
                    Text("4°")
                }

                Button(
                    onClick = {
                        semestre = 5
                    }
                ) {
                    Text("5°")
                }

                Button(
                    onClick = {
                        semestre = 6
                    }
                ) {
                    Text("6°")
                }


            }

            Spacer(modifier = Modifier.height(10.dp))

            // Me gusta
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // Botón -
                Button(
                    onClick = {
                        if (likes > 0) {
                            likes--
                        }
                    }
                ) {
                    Text("-")
                }

                // Contador
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "$likes",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text("Me gusta")
                }

                // Botón +
                Button(
                    onClick = {
                        likes++
                    }
                ) {
                    Text("+")
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botón Guardar
            // Por ahora NO realiza ninguna acción
            Button(
                onClick = {
                    // Sin acción
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
