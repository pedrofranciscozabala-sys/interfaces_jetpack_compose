package com.example.actidad_en_clase.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
fun NuevoPerfil() {

    // Datos personales
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var ciudad by remember { mutableStateOf("") }

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
                text = "Datos Personales",
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

            // Nombre mostrado en el perfil
            Text(
                text = nombre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            // Edad mostrada en el perfil
            if (edad.isNotBlank()) {
                Text(
                    text = "$edad años",
                    fontSize = 16.sp
                )
            }

            // Ciudad mostrada en el perfil
            Text(
                text = ciudad,
                fontSize = 16.sp
            )

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

            // Campo Edad
            OutlinedTextField(
                value = edad,
                onValueChange = {
                    edad = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Edad")
                },
                placeholder = {
                    Text("Escribe tu edad")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo Ciudad
            OutlinedTextField(
                value = ciudad,
                onValueChange = {
                    ciudad = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Ciudad")
                },
                placeholder = {
                    Text("Ciudad donde vives")
                }
            )

            Spacer(modifier = Modifier.height(15.dp))

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
