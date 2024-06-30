package com.example.myitstranskrip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

class TranskripActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TranskripScreen {
                    finish()
                }
            }
        }
    }
}

@Composable
fun TranskripScreen(onBackButtonClicked: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Transkrip", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBackButtonClicked) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF013880))
            )
        }
    ) {paddingValues ->
        Surface(color = Color(0xFF013880), modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.padding(8.dp)) {
                Header()
                Spacer(modifier = Modifier.height(16.dp))
                CourseList()
            }
        }
    }
}

@Composable
fun Header() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "Nama Mahasiswa:",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Prodi:",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "DAWAMUL FIKRI AQIL",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = "S-1 TEKNIK INFORMATIKA",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "NRP:",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "IPK:",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "5025201025",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = "3.98",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "Tahun Masuk:",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Jumlah Kredit:",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = "2020",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = "150",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun CourseList() {
    val courses = listOf(
        Course("Dasar Pemrograman", "IF4101 - 4 sks", "A"),
        Course("Matematika 1", "KM4101 - 3 sks", "A"),
        Course("Fisika 1", "SF4101 - 4 sks", "A"),
        Course("Kimia 1", "SK4101 - 3 sks", "A"),
        Course("Agama Islam", "UG4901 - 2 sks", "A"),
        Course("Pancasila", "UG4911 - 2 sks", "A"),
        Course("Bahasa Indonesia", "UG4912 - 2 sks", "A"),
        Course("Kewarganegaraan", "UG4913 - 2 sks", "A"),
        Course("Pemrograman Perangkat Bergerak", "EF234601 - 3 sks", "A"),
    )

    LazyColumn {
        items(courses) { course ->
            CourseItem(course)
        }
    }
}

@Composable
fun CourseItem(course: Course) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
//            .border(2.dp, color = Color.White, shape = RoundedCornerShape(4.dp))
            .background(color = Color.White, shape = RoundedCornerShape(4.dp))
    ) {
        Column(modifier = Modifier
            .weight(1f)
            .padding(4.dp)) {
            Text(text = course.name, fontSize = 16.sp)
            Text(text = course.details, fontSize = 14.sp, color = Color.Gray)
        }
        Text(
            text = "Nilai: ${course.grade}",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(4.dp)
        )
    }
}

data class Course(val name: String, val details: String, val grade: String)