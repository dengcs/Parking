// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protobuf/mode/user.proto

package com.parking.mode;

public final class User {
  private User() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface UserBaseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.parking.mode.UserBase)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * 用户编号
     * </pre>
     *
     * <code>uint64 uid = 1;</code>
     */
    long getUid();

    /**
     * <code>uint32 sex = 2;</code>
     */
    int getSex();

    /**
     * <code>string nickName = 3;</code>
     */
    java.lang.String getNickName();
    /**
     * <code>string nickName = 3;</code>
     */
    com.google.protobuf.ByteString
        getNickNameBytes();

    /**
     * <code>string account = 4;</code>
     */
    java.lang.String getAccount();
    /**
     * <code>string account = 4;</code>
     */
    com.google.protobuf.ByteString
        getAccountBytes();
  }
  /**
   * Protobuf type {@code com.parking.mode.UserBase}
   */
  public  static final class UserBase extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.parking.mode.UserBase)
      UserBaseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use UserBase.newBuilder() to construct.
    private UserBase(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private UserBase() {
      uid_ = 0L;
      sex_ = 0;
      nickName_ = "";
      account_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private UserBase(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              uid_ = input.readUInt64();
              break;
            }
            case 16: {

              sex_ = input.readUInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              nickName_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              account_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.parking.mode.User.internal_static_com_parking_mode_UserBase_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.parking.mode.User.internal_static_com_parking_mode_UserBase_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.parking.mode.User.UserBase.class, com.parking.mode.User.UserBase.Builder.class);
    }

    public static final int UID_FIELD_NUMBER = 1;
    private long uid_;
    /**
     * <pre>
     * 用户编号
     * </pre>
     *
     * <code>uint64 uid = 1;</code>
     */
    public long getUid() {
      return uid_;
    }

    public static final int SEX_FIELD_NUMBER = 2;
    private int sex_;
    /**
     * <code>uint32 sex = 2;</code>
     */
    public int getSex() {
      return sex_;
    }

    public static final int NICKNAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object nickName_;
    /**
     * <code>string nickName = 3;</code>
     */
    public java.lang.String getNickName() {
      java.lang.Object ref = nickName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nickName_ = s;
        return s;
      }
    }
    /**
     * <code>string nickName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getNickNameBytes() {
      java.lang.Object ref = nickName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nickName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ACCOUNT_FIELD_NUMBER = 4;
    private volatile java.lang.Object account_;
    /**
     * <code>string account = 4;</code>
     */
    public java.lang.String getAccount() {
      java.lang.Object ref = account_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        account_ = s;
        return s;
      }
    }
    /**
     * <code>string account = 4;</code>
     */
    public com.google.protobuf.ByteString
        getAccountBytes() {
      java.lang.Object ref = account_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        account_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (uid_ != 0L) {
        output.writeUInt64(1, uid_);
      }
      if (sex_ != 0) {
        output.writeUInt32(2, sex_);
      }
      if (!getNickNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, nickName_);
      }
      if (!getAccountBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, account_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (uid_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, uid_);
      }
      if (sex_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(2, sex_);
      }
      if (!getNickNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, nickName_);
      }
      if (!getAccountBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, account_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.parking.mode.User.UserBase)) {
        return super.equals(obj);
      }
      com.parking.mode.User.UserBase other = (com.parking.mode.User.UserBase) obj;

      boolean result = true;
      result = result && (getUid()
          == other.getUid());
      result = result && (getSex()
          == other.getSex());
      result = result && getNickName()
          .equals(other.getNickName());
      result = result && getAccount()
          .equals(other.getAccount());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + UID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getUid());
      hash = (37 * hash) + SEX_FIELD_NUMBER;
      hash = (53 * hash) + getSex();
      hash = (37 * hash) + NICKNAME_FIELD_NUMBER;
      hash = (53 * hash) + getNickName().hashCode();
      hash = (37 * hash) + ACCOUNT_FIELD_NUMBER;
      hash = (53 * hash) + getAccount().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.parking.mode.User.UserBase parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.parking.mode.User.UserBase parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.parking.mode.User.UserBase parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.parking.mode.User.UserBase parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.parking.mode.User.UserBase parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.parking.mode.User.UserBase parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.parking.mode.User.UserBase parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.parking.mode.User.UserBase parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.parking.mode.User.UserBase parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.parking.mode.User.UserBase parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.parking.mode.User.UserBase parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.parking.mode.User.UserBase parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.parking.mode.User.UserBase prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.parking.mode.UserBase}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.parking.mode.UserBase)
        com.parking.mode.User.UserBaseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.parking.mode.User.internal_static_com_parking_mode_UserBase_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.parking.mode.User.internal_static_com_parking_mode_UserBase_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.parking.mode.User.UserBase.class, com.parking.mode.User.UserBase.Builder.class);
      }

      // Construct using com.parking.mode.User.UserBase.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        uid_ = 0L;

        sex_ = 0;

        nickName_ = "";

        account_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.parking.mode.User.internal_static_com_parking_mode_UserBase_descriptor;
      }

      public com.parking.mode.User.UserBase getDefaultInstanceForType() {
        return com.parking.mode.User.UserBase.getDefaultInstance();
      }

      public com.parking.mode.User.UserBase build() {
        com.parking.mode.User.UserBase result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.parking.mode.User.UserBase buildPartial() {
        com.parking.mode.User.UserBase result = new com.parking.mode.User.UserBase(this);
        result.uid_ = uid_;
        result.sex_ = sex_;
        result.nickName_ = nickName_;
        result.account_ = account_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.parking.mode.User.UserBase) {
          return mergeFrom((com.parking.mode.User.UserBase)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.parking.mode.User.UserBase other) {
        if (other == com.parking.mode.User.UserBase.getDefaultInstance()) return this;
        if (other.getUid() != 0L) {
          setUid(other.getUid());
        }
        if (other.getSex() != 0) {
          setSex(other.getSex());
        }
        if (!other.getNickName().isEmpty()) {
          nickName_ = other.nickName_;
          onChanged();
        }
        if (!other.getAccount().isEmpty()) {
          account_ = other.account_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.parking.mode.User.UserBase parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.parking.mode.User.UserBase) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long uid_ ;
      /**
       * <pre>
       * 用户编号
       * </pre>
       *
       * <code>uint64 uid = 1;</code>
       */
      public long getUid() {
        return uid_;
      }
      /**
       * <pre>
       * 用户编号
       * </pre>
       *
       * <code>uint64 uid = 1;</code>
       */
      public Builder setUid(long value) {
        
        uid_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 用户编号
       * </pre>
       *
       * <code>uint64 uid = 1;</code>
       */
      public Builder clearUid() {
        
        uid_ = 0L;
        onChanged();
        return this;
      }

      private int sex_ ;
      /**
       * <code>uint32 sex = 2;</code>
       */
      public int getSex() {
        return sex_;
      }
      /**
       * <code>uint32 sex = 2;</code>
       */
      public Builder setSex(int value) {
        
        sex_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 sex = 2;</code>
       */
      public Builder clearSex() {
        
        sex_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object nickName_ = "";
      /**
       * <code>string nickName = 3;</code>
       */
      public java.lang.String getNickName() {
        java.lang.Object ref = nickName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          nickName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string nickName = 3;</code>
       */
      public com.google.protobuf.ByteString
          getNickNameBytes() {
        java.lang.Object ref = nickName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          nickName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string nickName = 3;</code>
       */
      public Builder setNickName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        nickName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string nickName = 3;</code>
       */
      public Builder clearNickName() {
        
        nickName_ = getDefaultInstance().getNickName();
        onChanged();
        return this;
      }
      /**
       * <code>string nickName = 3;</code>
       */
      public Builder setNickNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        nickName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object account_ = "";
      /**
       * <code>string account = 4;</code>
       */
      public java.lang.String getAccount() {
        java.lang.Object ref = account_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          account_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string account = 4;</code>
       */
      public com.google.protobuf.ByteString
          getAccountBytes() {
        java.lang.Object ref = account_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          account_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string account = 4;</code>
       */
      public Builder setAccount(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        account_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string account = 4;</code>
       */
      public Builder clearAccount() {
        
        account_ = getDefaultInstance().getAccount();
        onChanged();
        return this;
      }
      /**
       * <code>string account = 4;</code>
       */
      public Builder setAccountBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        account_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.parking.mode.UserBase)
    }

    // @@protoc_insertion_point(class_scope:com.parking.mode.UserBase)
    private static final com.parking.mode.User.UserBase DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.parking.mode.User.UserBase();
    }

    public static com.parking.mode.User.UserBase getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<UserBase>
        PARSER = new com.google.protobuf.AbstractParser<UserBase>() {
      public UserBase parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new UserBase(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<UserBase> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<UserBase> getParserForType() {
      return PARSER;
    }

    public com.parking.mode.User.UserBase getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_parking_mode_UserBase_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_parking_mode_UserBase_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030protobuf/mode/user.proto\022\020com.parking." +
      "mode\"G\n\010UserBase\022\013\n\003uid\030\001 \001(\004\022\013\n\003sex\030\002 \001" +
      "(\r\022\020\n\010nickName\030\003 \001(\t\022\017\n\007account\030\004 \001(\tb\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_parking_mode_UserBase_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_parking_mode_UserBase_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_parking_mode_UserBase_descriptor,
        new java.lang.String[] { "Uid", "Sex", "NickName", "Account", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
