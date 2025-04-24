import argparse

def main():
    parser = argparse.ArgumentParser(description="欢迎程序")
    parser.add_argument("name", help="你的名字")
    parser.add_argument("--age", type=int, help="你的年龄", required=False)

    args = parser.parse_args()

    if args.age:
        print(f"你好，{args.name}！你今年 {args.age} 岁。")
    else:
        print(f"你好，{args.name}！")

if __name__ == "__main__":
    main()
