# Instagram Login Android UI

A complete Instagram login interface for Android using Java and Material Design components.

## Features

- ✅ Complete Instagram login design
- ✅ Email/Username input field (empty)
- ✅ Password input field with show/hide toggle
- ✅ Login button with validation
- ✅ Forgot password link
- ✅ Facebook login integration ready
- ✅ Sign up navigation
- ✅ Material Design 3 components
- ✅ Responsive design
- ✅ Proper input validation

## Project Structure

```
Instagram-Login-Android/
├── app/
│   ├── src/main/
│   │   ├── java/com/instagram/login/
│   │   │   └── MainActivity.java
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml
│   │   │   ├── drawable/
│   │   │   │   └── facebook_button_background.xml
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml
│   │   │   │   └── themes.xml
│   │   │   └── font/
│   │   │       └── instagram_font.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── settings.gradle
└── build.gradle
```

## How to Use

1. **Clone the repository:**
   ```bash
   git clone https://github.com/abdullahalraes2-ui/Instagram-Login-Android.git
   ```

2. **Open in Android Studio:**
   - File → Open → Select the project folder
   - Wait for Gradle sync to complete

3. **Run the app:**
   - Connect an Android device or start an emulator
   - Click Run → Run 'app'

## UI Components

### Email/Username Field
- Material TextInputLayout with hint
- Light gray background (#F3F3F3)
- Border color: #DADADA
- Supports email and username input

### Password Field
- Material TextInputLayout with password toggle
- Show/Hide password functionality
- Same styling as email field

### Login Button
- Instagram blue color (#385185)
- Enabled only when inputs are valid
- Email must not be empty
- Password must be at least 6 characters

### Additional Features
- Forgot password link (clickable)
- Facebook login button
- Sign up link (clickable)
- Responsive scrollable layout

## Customization

### Colors
Edit `app/src/main/res/values/colors.xml` to change:
- Button colors
- Text colors
- Background colors

### Strings
Edit `app/src/main/res/values/strings.xml` to change:
- Button text
- Hint text
- Links text

## Requirements

- Android SDK 24 or higher
- Android Studio 2021.1 or higher
- Java 11 or higher
- Material Design 3 library

## Dependencies

- AndroidX AppCompat
- Material Design Components
- ConstraintLayout

## License

This project is open source and available for educational purposes.

## Author

Created by Abdullah AlRaes

## Support

For issues and questions, please create an issue on GitHub.
