# 🚆 TrainMerger

A command-line Java application that simulates two trains merging at a junction and departing in sorted bogie order based on their final destinations.

---

## 🔗 Repository

**GitHub Repo:** [https://github.com/deepanshu1531/TrainMerger.git](https://github.com/deepanshu1531/TrainMerger.git)

---

## 📌 Problem Statement

- There are two super-fast trains: **Train A** and **Train B**.
- They start from different cities and **merge at Hyderabad (HYB)**.
- After merging, they travel as **Train AB**, and the bogies are ordered by descending distance from HYB.
- The trains can carry passengers to stations from either route.

---

## ✅ Features

- Reads multiple test cases from a **single input file**
- Validates station codes & distances
- Handles empty input, invalid stations, and I/O errors
- Prints:
  - Arrival order at Hyderabad
  - Departure order from Hyderabad

---

## 📂 Folder Structure
```
TrainMerger/
├── src/
│ └── com/train/
│ ├── Main.java
│ ├── StationInfo.java
│ └── TrainMerger.java
│ └── input.txt <-- Place your input file here
├── pom.xml
```

---

## 🧾 Input Format

- The input file must contain multiple pairs of lines:

TRAIN_A ENGINE <BOGIE1> <BOGIE2> ...
TRAIN_B ENGINE <BOGIE1> <BOGIE2> ...

- Example (`input.txt`):
TRAIN_A ENGINE NDL NDL KRN GHY SLM NJP NGP BLR
TRAIN_B ENGINE NJP GHY AGA PNE MAO BPL PTA

TRAIN_A ENGINE SLM BLR KRN HYB SLM NGP ITJ
TRAIN_B ENGINE SRR MAO NJP PNE PTA

---

## 📤 Output Format

- For each test case:
ARRIVAL TRAIN_A ENGINE ...
ARRIVAL TRAIN_B ENGINE ...
DEPARTURE TRAIN_AB ENGINE ENGINE ...

### Example Output:

ARRIVAL TRAIN_A ENGINE NDL NDL GHY NJP NGP
ARRIVAL TRAIN_B ENGINE NJP GHY AGA BPL PTA
DEPARTURE TRAIN_AB ENGINE ENGINE GHY GHY NJP NJP PTA NDL NDL AGA BPL NGP

ARRIVAL TRAIN_A ENGINE HYB NGP ITJ
ARRIVAL TRAIN_B ENGINE NJP PTA
DEPARTURE TRAIN_AB ENGINE ENGINE NJP PTA ITJ NGP

---

## ⚙️ How to Run

### 🔁 Clone the repository
```bash
git clone https://github.com/deepanshu1531/TrainMerger.git
cd TrainMerger
mvn clean package
java -cp target/TrainMerger-1.0-SNAPSHOT.jar com.train.Main
```

## 👨‍💻 Author: Deepanshu Verma
### 🔗 GitHub: [@deepanshu1531](https://github.com/deepanshu1531)
### 🌐 Portfolio:[ deepanshu1531.github.io/portfolio](https://deepanshu1531.github.io/portfolio/#)
