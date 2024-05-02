digit_names = {
    0: "zer", 1: "one", 2: "two", 3: "thr", 4: "fou", 5: "fiv", 6: "six", 7: "sev", 8: "eig", 9: "nin"
}

def generate_captcha(number, name):
    if not name.islower():
        return "Invalid"
    try:
        if number[0] == '-':
            s1 = "-"
            number = number[1:]
        else:
            s1 = ""

        num = float(number)
        res = '{:e}'.format(num)

        startnum = int(res[0])

        sum_digits = sum(int(digit) for digit in number if digit != '.')
        add_value = (sum_digits - startnum)
        if add_value % 9 == 0 and add_value != 0:
            add_value = 9
        else:
            add_value = add_value % 9

        e_value = int(res.split("e")[-1])
        if e_value > 9:
            e_value = e_value % 9

        s1 = s1 + digit_names[startnum] + "." + digit_names[add_value] + "e"
        if e_value > 0:
            s1 = s1 + "+" + digit_names[e_value]
        elif e_value == 0:
            s1 = s1 + digit_names[e_value]
        else:
            k = -e_value
            s1 = s1 + "-" + digit_names[k]

        s2 = "@"
        if e_value & 1 == 1:
            for j in range(len(name)):
                if j & 1 == 0:
                    s2 = s2 + name[j]
        else:
            for j in range(len(name)):
                if j & 1 == 1:
                    s2 = s2 + name[j]

        captcha_code = f"{s1}{s2}"

    except (ValueError, AttributeError):
        captcha_code = "Invalid"

    return captcha_code

t = int(input())

for _ in range(t):
    number, name = input().split()
    captcha_code = generate_captcha(number, name)
    print(captcha_code)
